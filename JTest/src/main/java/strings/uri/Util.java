package strings.uri;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 30.11.14
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
public class Util {

    //TODO: test
    public static String addParameterToUri(String uri, String paramName, String paramValue){
        if(uri.indexOf("=") == -1)
            return uri + "?" + paramName + "=" + paramValue;
        return uri + "&" + paramName + "=" + paramValue;
    }

    //TODO: impl, test
    public static String removeParameterFromUri(String uri, String paramName) {
        int i = uri.indexOf(paramName);
        int j = uri.indexOf('&', i);
        if((i != -1) && (j == -1)){
            j = uri.indexOf('&', i - 1);
            if(j != -1)
                return uri.substring(0, i - 1);
            return uri.substring(0, i);
        }

        return uri.substring(0, i - 1) + uri.substring(j, uri.length() - 1);
    }

}
