package rest.service;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

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
