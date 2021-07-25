package service;

import okhttp3.HttpUrl;
import org.apache.http.client.utils.URIBuilder;
import org.assertj.core.internal.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public interface RESTService {

    Logger LOG = LoggerFactory.getLogger("RestClient");
    String PARAMETER = "/{%s}";

    <T> T authorize();

    default URL getURL(String serviceUrl, String... request) {
        URL url = null;
        try {
            url = new URIBuilder(serviceUrl).setPathSegments(request).build().toURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    default String getURLWithParameters(String serviceUrl, String parameterURL, String... request) {
        URL url = getURL(serviceUrl, request);
        return url.toString() + String.format(PARAMETER, parameterURL);
    }
}
