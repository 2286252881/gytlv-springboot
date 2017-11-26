package com.zh.gytlv.config;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;
@Configuration
public class UrlRewriteFilterConfig extends UrlRewriteFilter {
	private static final String URL_REWRITE = "classpath:/urlrewrite.xml";
	@Value(URL_REWRITE)
	private Resource resource;
	protected void loadUrlRewriter(FilterConfig filterConfig) throws ServletException {
		try {
			Conf conf = new Conf(filterConfig.getServletContext(), resource.getInputStream(), resource.getFilename(), "@@traceability@@");
			checkConf(conf);
		} catch (IOException ex) {
			throw new ServletException("Unable to load URL rewrite configuration file from " + URL_REWRITE, ex);
		}
	}
}
