package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public interface RESTService {

    Logger LOG = LoggerFactory.getLogger("RestClient");

    void authorize();

    default  URL getURL(String serviceUrl, String request) {
        try {
            return new URL(serviceUrl + "/" + request);
        } catch (MalformedURLException e) {
            LOG.error("URL " + serviceUrl + "/" + request + " is incorrect " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
