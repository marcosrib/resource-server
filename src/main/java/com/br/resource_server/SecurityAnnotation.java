package com.br.resource_server;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.access.prepost.PreAuthorize;

public class SecurityAnnotation {
    
    @Retention(RetentionPolicy.RUNTIME)
    @PreAuthorize("hasAuthority('SCOPE_apis:read')")
    public @interface CanReadApis {}

    @Retention(RetentionPolicy.RUNTIME)
    @PreAuthorize("hasAuthority('SCOPE_apis:write')")
    public @interface CanWriteApis {}
}
