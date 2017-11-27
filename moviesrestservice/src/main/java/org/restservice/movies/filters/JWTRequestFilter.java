package org.restservice.movies.filters;

import java.io.IOException;
import java.security.Principal;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;

//@Provider
public class JWTRequestFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String AUTHORIZATION_HEADER_JWT_PREFIX = "Bearer";

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
//		String authHeader = requestContext.getHeaderString(AUTHORIZATION_HEADER_KEY);
//		if(authHeader != null && authHeader.startsWith(AUTHORIZATION_HEADER_PREFIX)) {
//			String authToken = authHeader.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
//			String decodedString = Base64.decodeAsString(authToken.trim());
//			String[] authTokens = decodedString.split(":");
//			String username = authTokens[0];
//			String password = authTokens[1];
//			if("restmovies@gmail.com".equals(username) && "restmovies".equals(password)) {
//				return;
//			}			
//		}
//		else if (authHeader.startsWith(AUTHORIZATION_HEADER_JWT_PREFIX)) {
//            try {
//                System.out.println("JWT based Auth in action... time to verify th signature");
//                String jwtToken = authHeader.split(" ")[1];
//                System.out.println("JWT being tested:\n" + jwtToken);
//                final String subject = validate(jwtToken);
//                final SecurityContext securityContext = requestContext.getSecurityContext();
//                if (subject != null) {
//                    requestContext.setSecurityContext(new SecurityContext() {
//                        @Override
//                        public Principal getUserPrincipal() {
//                            return new Principal() {
//                                @Override
//                                public String getName() {
//                                    System.out.println("Returning custom Principal - " + subject);
//                                    return subject;
//                                }
//                            };
//                        }
//
//                        @Override
//                        public boolean isUserInRole(String role) {
//                            return securityContext.isUserInRole(role);
//                        }
//
//                        @Override
//                        public boolean isSecure() {
//                            return securityContext.isSecure();
//                        }
//
//                        @Override
//                        public String getAuthenticationScheme() {
//                            return securityContext.getAuthenticationScheme();
//                        }
//                    });
//                }
//            } catch (InvalidJwtException ex) {
//                System.out.println("JWT validation failed");
//
//                requestContext.setProperty("auth-failed", true);
//                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
//
//            }
//
//        } else {
//            System.out.println("No JWT token !");
//            requestContext.setProperty("auth-failed", true);
//            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
//        }
	}
	
    private String validate(String jwt) throws InvalidJwtException {
        String subject = null;
        RsaJsonWebKey rsaJsonWebKey = RsaKeyProducer.produce();

        System.out.println("RSA hash code... " + rsaJsonWebKey.hashCode());

        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireSubject() // the JWT must have a subject claim
                .setVerificationKey(rsaJsonWebKey.getKey()) // verify the signature with the public key
                .build(); // create the JwtConsumer instance

        try {
            //  Validate the JWT and process it to the Claims
            JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
            subject = (String) jwtClaims.getClaimValue("sub");
            System.out.println("JWT validation succeeded! " + jwtClaims);
        } catch (InvalidJwtException e) {
            e.printStackTrace(); //on purpose
            throw e;
        }

        return subject;
    }
}
