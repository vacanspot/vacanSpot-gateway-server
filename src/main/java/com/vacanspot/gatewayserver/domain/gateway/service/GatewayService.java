package com.vacanspot.gatewayserver.domain.gateway.service;

import com.vacanspot.gatewayserver.domain.gateway.feign.LocationClient;
import com.vacanspot.gatewayserver.domain.gateway.feign.SearchClient;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GatewayService {
    private final LocationClient locationClient;
    private final SearchClient searchClient;

    public String getLocation(
            final String x,
            final String y
    ) {
        return locationClient.getLocation(x, y);
    }

    public List<String> getRecommendImages(
            final String x,
            final String y,
            final String q
    ) {
        return StringUtils.isBlank(q) ?
                getRecommendImages(x, y):
                getRecommendImages(q);
    }

    public List<String> getRecommendImages(
            final String x,
            final String y
    ) {
        String location = locationClient.getLocation(x, y);

        return searchClient.getRecommendedImages(location);
    }

    public List<String> getRecommendImages(
            final String query
    ) {
        return searchClient.getRecommendedImages(query);
    }
}
