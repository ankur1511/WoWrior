package com.ankur.Controller;

import java.net.URI;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.ankur.Entity.User;
import com.ankur.Service.UserServiceImpl;

@Controller
public class API_Implementation {


	UserServiceImpl userService = new UserServiceImpl();
	Random randomGenerator = new Random();
	int placeId = 0;

	@RequestMapping(value = "/user/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriBuilder) throws Exception {

		
		if (!userService.CheckAddress(user.getAddress())) {
			userService.storeAddress(user.getAddress());
			placeId = randomGenerator.nextInt(100);
			userService.CreateUser(user, placeId);
		}

		else {
			placeId = userService.getPlaceID();
			userService.CreateUser(user, placeId);
		}

		URI uri = uriBuilder.path("/user/create").build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}
