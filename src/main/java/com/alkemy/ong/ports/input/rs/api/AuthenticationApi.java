package com.alkemy.ong.ports.input.rs.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import com.alkemy.ong.common.exception.error.ErrorDetails;
import com.alkemy.ong.domain.model.User;
import com.alkemy.ong.ports.input.rs.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@Validated
@SecurityRequirement(name = "bearerAuth")
public interface AuthenticationApi {
	
	@Operation(summary = "Get current user information", responses = {
			@ApiResponse(description = "User deleted", responseCode = "200"),
			@ApiResponse(responseCode = "401", description = "Invalid token or token expired", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)) }),
			@ApiResponse(responseCode = "403", description = "Invalid Role", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal error", content = @Content) })
	UserResponse meData(@AuthenticationPrincipal @Parameter(hidden = true) User user);

}
