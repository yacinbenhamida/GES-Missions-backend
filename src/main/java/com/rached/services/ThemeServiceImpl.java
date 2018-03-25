package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.Theme;
import com.rached.model.Zonepays;
@Service
@Qualifier("themeServiceImpl")
public class ThemeServiceImpl implements Services<Theme> {
	@Autowired
	private ThemeRepository repo;
	@Override
	public List<Theme> getAllRecords() {
		List<Theme> res = new ArrayList();
		Iterator<Theme>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Theme getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public Theme insertRecord(Theme elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		Theme zp = repo.findOne(id);
		repo.delete(zp);	
	}

	@Override
	public Theme updateRecord(Theme elem) {
		return repo.save(elem);
	}

	@Override
	public Theme getRecordBycode(String id) {
		return repo.findOne(id);
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repo.delete(valueOf);	
	}
}
