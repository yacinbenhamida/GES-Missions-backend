package com.rached.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public interface Services<T> {
	List<T> getAllRecords();
	T getRecordById(Long id);
	T insertRecord(T elem);
	void deleteRecord(int id);
	T updateRecord(T elem);
	T getRecordBycode(String id);
	void deleteRecord(Long valueOf);
}
