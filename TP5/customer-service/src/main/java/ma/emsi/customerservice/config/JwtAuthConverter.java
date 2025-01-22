package ma.emsi.customerservice.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter=new JwtGrantedAuthoritiesConverter();


    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                extractResourceRoles(jwt).stream()
        ).collect(Collectors.toSet());
        return new JwtAuthenticationToken(jwt, authorities,jwt.getClaim("preferred_username"));
    }

    private Collection<GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String , Object> resourceAccess;
        Collection<String> roles=null;
        if(jwt.getClaim("resource_access")==null){
            return Set.of();
        }
        resourceAccess = jwt.getClaim("resource_access");
        if (resourceAccess.containsKey("customer-service")) {
            Map<String, Object> customerService = (Map<String, Object>) resourceAccess.get("customer-service");
            roles = (Collection<String>) customerService.get("roles");
        }
        System.out.println("roles = "+roles);
        return roles.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet());
    }

}
/*
JWT :
{
  "exp": 1736602102,
  "iat": 1736601802,
  "jti": "52443346-3487-48bd-8481-e5c7a0b0d95d",
  "iss": "http://localhost:8080/realms/ecom-realm",
  "aud": "account",
  "sub": "f11028a8-873b-4750-b335-6f02d13da9a4",
  "typ": "Bearer",
  "azp": "customer-service",
  "sid": "35241202-2804-4bfb-ba7c-075b4ec51fe8",
  "acr": "1",
  "allowed-origins": [
    "/*"
  ],
  "realm_access": {
    "roles": [
      "default-roles-ecom-realm",
      "offline_access",
      "uma_authorization"
    ]
  },
  "resource_access": {
    "customer-service": {
      "roles": [
        "ADMIN",
        "USER"
      ]
    },
    "account": {
      "roles": [
        "manage-account",
        "manage-account-links",
        "view-profile"
      ]
    }
  },
  "scope": "email profile",
  "email_verified": false,
  "name": "hamza aitahmed",
  "preferred_username": "hamza.aitahmed",
  "given_name": "hamza",
  "family_name": "aitahmed",
  "email": "hamza@gmail.com"
}
 */
