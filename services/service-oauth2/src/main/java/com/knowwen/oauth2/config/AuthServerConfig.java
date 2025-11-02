package com.knowwen.oauth2.config;

import com.knowwen.oauth2.service.UserService;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity // 开启 Spring Security 基础功能
public class AuthServerConfig {

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // @Bean 
	// @Order(1)
	// public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http)
	// 		throws Exception {

	// 	OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
	// 	http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
	// 		.oidc(Customizer.withDefaults());	// Enable OpenID Connect 1.0
	// 	http
	// 		// Redirect to the login page when not authenticated from the
	// 		// authorization endpoint
	// 		.exceptionHandling((exceptions) -> exceptions
	// 			.defaultAuthenticationEntryPointFor(
	// 				new LoginUrlAuthenticationEntryPoint("/login"),
	// 				new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
	// 			)
	// 		)
	// 		// Accept access tokens for User Info and/or Client Registration
	// 		.oauth2ResourceServer((resourceServer) -> resourceServer
	// 			.jwt(Customizer.withDefaults()));

	// 	return http.build();
	// }

	// @Bean 
	// @Order(2)
	// public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
	// 		throws Exception {
	// 	http
	// 		.authorizeHttpRequests((authorize) -> authorize
	// 			.requestMatchers("/oauth2/**").permitAll()
	// 			.anyRequest().authenticated()
	// 		)
	// 		// Form login handles the redirect to the login page from the
	// 		// authorization server filter chain
	// 		.formLogin(Customizer.withDefaults());

	// 	return http.build();
	// }

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails userDetails = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.authorities("profile","openid","user")
//				.build();
//
//		return new InMemoryUserDetailsManager(userDetails);
//	}

	// @Bean
	// public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
	// 	return new DefaultOAuth2UserService() {
	// 		@Override
	// 		public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
	// 			OAuth2User user = super.loadUser(userRequest);
	// 			// Map OAuth2 provider roles to Spring Security roles
	// 			Collection<? extends GrantedAuthority> authorities = 
	// 				user.getAuthorities().stream()
	// 					.map(auth -> new SimpleGrantedAuthority("ROLE_" + auth.getAuthority().toUpperCase()))
	// 					.collect(Collectors.toList());
	// 			return new DefaultOAuth2User(authorities, user.getAttributes(), "name");
	// 		}
	// 	};
	// }

	// @Bean 
	// public RegisteredClientRepository registeredClientRepository() {
	// 	RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
	// 			.clientId("oidc-client")
	// 			.clientSecret("{noop}secret")
	// 			// .clientSecret("secret")
	// 			// accept client credentials via HTTP Basic header
	// 			.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
	// 			// also accept client_secret in request body
	// 			.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
	// 			.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
	// 			.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
	// 			.redirectUri("http://127.0.0.1/login/oauth2/code/gateway")
	// 			.postLogoutRedirectUri("http://127.0.0.1/")
	// 			.scope(OidcScopes.OPENID)
	// 			.scope(OidcScopes.PROFILE)
	// 			.scope("user")
	// 			.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
	// 			.build();

	// 	return new InMemoryRegisteredClientRepository(oidcClient);
	// }


	@Bean 
	public JWKSource<SecurityContext> jwkSource() {
		KeyPair keyPair = generateRsaKey();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		RSAKey rsaKey = new RSAKey.Builder(publicKey)
				.privateKey(privateKey)
				.keyID(UUID.randomUUID().toString())
				.build();
		JWKSet jwkSet = new JWKSet(rsaKey);
		return new ImmutableJWKSet<>(jwkSet);
	}

	private static KeyPair generateRsaKey() { 
		KeyPair keyPair;
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			keyPair = keyPairGenerator.generateKeyPair();
		}
		catch (Exception ex) {
			throw new IllegalStateException(ex);
		}
		return keyPair;
	}

	@Bean 
	public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
		return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
	}

	@Bean 
	public AuthorizationServerSettings authorizationServerSettings() {
		return AuthorizationServerSettings.builder().build();
	}

	// @Bean
    // public OAuth2AuthorizationServerConfigurer authorizationServerConfigurer() {
    //     return new OAuth2AuthorizationServerConfigurer();
    // }
}
