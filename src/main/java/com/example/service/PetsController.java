package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PetsController {

	@QueryMapping
	List<Pet> getPets(@Argument PetFilter filter) {
		System.out.println("----filter---" + filter.getName());
		List<Pet> petList = List.of(new Pet("Luna", "black", 5), new Pet("Skipper", "black", 7), new Pet("Dan", "white", 7));
		return getFilteredList(petList, filter);
	}

	private static List<Pet> getFilteredList(List<Pet> originalList, PetFilter petFilter) {
		Predicate<Pet> filter = Stream
				.of(compare(Pet::getName, petFilter.getName()), compare(Pet::getColor, petFilter.getColor()),
						compare(Pet::getAge, petFilter.getAge()))
				.filter(Objects::nonNull).reduce(Predicate::and).orElse(x -> true);

		return originalList.stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
	}

	private static Predicate<Pet> compare(Function<Pet, Object> field, Object value) {
		return value == null ? null : m -> field.apply(m).equals(value);
	}

}
