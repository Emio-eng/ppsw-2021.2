/**
 * <p>
 * UPE - Campus Garanhuns Curso de Engenharia de Software Disciplina de Padrões de Projeto de
 * Software Copyright 2021 the original author or authors.
 * </p>
 * 
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-@Override
	2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * </p>
 * 
 * @author Ian F. Darwin, hbarreiros
 */
package br.upe.ppsw.jabberpoint.control;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

import br.upe.ppsw.jabberpoint.model.Presentation;

public class JSONFormat implements IFilePresentationFormat {

	@Override
	public Presentation load(String fileName) {
		// TODO Auto-generated method stub
//		return null;
		Path path = Paths.get(fileName);

		try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			Gson gson = new Gson();
			Presentation presentationjson = gson.fromJson(reader, Presentation.class);
			return presentationjson;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(Presentation presentation, String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getExtension() {
		return "json";
	}



}
