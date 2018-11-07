package com.javatpoint.controllers;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class MyFile implements Serializable {
	private static final long serialVersionUID = 1L;
	private MultipartFile multipartFile;
	private String description;
}