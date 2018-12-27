package com.java.todo;

import com.java.todo.repository.UtilisateurRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoApplicationTests {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Test
	public void contextLoads() {
		//Given

		//When
		long nbUtilisateur = utilisateurRepository.count();
		//Then
		Assert.assertTrue(nbUtilisateur > 0);
	}

}

