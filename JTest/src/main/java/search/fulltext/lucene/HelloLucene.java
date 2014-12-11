package search.fulltext.lucene;

import org.apache.lucene.analysis.standard.ClassicAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloLucene {
    public static void main(String[] args) throws IOException, ParseException {
        // 0. Specify the analyzer for tokenizing text.
        //    The same analyzer should be used for indexing and searching
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);

        ClassicAnalyzer classicAnalyzer = new ClassicAnalyzer(Version.LUCENE_40);

        // 1. create the index
        Directory index = new RAMDirectory();

        ScoreDoc[] hits = null;
        IndexSearcher searcher = null;
        IndexReader reader = null;

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);

        IndexWriter w = new IndexWriter(index, config);

        String text = getTextFromFile("text");

        addDoc(w, text, "193398817");
        addDoc(w, "Lucene for Dummies", "55320055Z");
        addDoc(w, "Managing Gigabytes", "55063554A");
        addDoc(w, "The Art of Computer Science", "9900333X");
        addDoc(w, "Lucene in Action", "193398819");
        addDoc(w, "Lucene for Dummies", "55320055Z");
        addDoc(w, "Managing Gigabytes", "55063554A");
        addDoc(w, "The Art of War", "9900333X");
        w.close();

        // 2. query
        String querystr = args.length > 0 ? args[0] : "cancer";
        String querystr1 = args.length > 0 ? args[0] : "Mage";

        // the "title" arg specifies the default field to use
        // when no field is explicitly specified in the query.
        Query q = new QueryParser(Version.LUCENE_40, "title", analyzer).parse(querystr);
        Query q1 = new QueryParser(Version.LUCENE_40, "title", classicAnalyzer).parse(querystr1);

        SearchStruct searchStruct = new SearchStruct(q, hits, searcher, reader, index);

        searchStruct.search();
        searchStruct.displayResults();

        searchStruct.setQuery(q1);
        searchStruct.search();
        searchStruct.displayResults();

        searchStruct.closeReader();


        // reader can only be closed when there
        // is no need to access the documents any more.

        // Classic analyzer

    }

    private static String getTextFromFile(String filename) {

        File file = new File(filename);
        StringBuilder text = new StringBuilder("");

        try {
            byte[] buffer = new byte[8192];


            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.read() != -1){
                fileInputStream.read(buffer);
                text.append(new String(buffer));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(text);
    }


    private static void addDoc(IndexWriter w, String title, String isbn) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));

        // use a string field for isbn because we don't want it tokenized
        doc.add(new StringField("isbn", isbn, Field.Store.YES));
        w.addDocument(doc);
    }

    static class SearchStruct{

        Query query;
        ScoreDoc[] hits;
        IndexSearcher searcher;
        IndexReader reader;
        Directory index;


        SearchStruct(Query query, ScoreDoc[] hits, IndexSearcher searcher, IndexReader reader, Directory index) {
            this.query = query;
            this.hits = hits;
            this.searcher = searcher;
            this.reader = reader;
            this.index = index;
        }

        private void search() throws IOException {

            // 3. search
            int hitsPerPage = 10;
            reader = DirectoryReader.open(index);
            searcher = new IndexSearcher(reader);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
            searcher.search(query, collector);
            hits = collector.topDocs().scoreDocs;


        }

        private void displayResults() throws IOException {

            // 4. display results
            System.out.println("Found " + hits.length + " hits.");
            for(int i=0;i<hits.length;++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title"));
            }

            System.out.println("");
            System.out.println("");
        }

        public void closeReader() throws IOException {
            reader.close();
        }

        public Query getQuery() {
            return query;
        }

        public void setQuery(Query query) {
            this.query = query;
        }

        public ScoreDoc[] getHits() {
            return hits;
        }

        public void setHits(ScoreDoc[] hits) {
            this.hits = hits;
        }

        public IndexSearcher getSearcher() {
            return searcher;
        }

        public void setSearcher(IndexSearcher searcher) {
            this.searcher = searcher;
        }

        public IndexReader getReader() {
            return reader;
        }

        public void setReader(IndexReader reader) {
            this.reader = reader;
        }

        public Directory getIndex() {
            return index;
        }

        public void setIndex(Directory index) {
            this.index = index;
        }
    }
}
