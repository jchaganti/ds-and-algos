package org.jch.cci.stacksNQueues;

import java.util.LinkedList;

public class A06AnimalShelter {

	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		int total = 6;
		for(int i = 0; i < total; i++) {
			if(i%2 == 0) {
				shelter.enqueue( new Dog(i, "Doggy" + i));
			}
			else {
				shelter.enqueue( new Cat(i, "Catty" + i));
			}
		}

		System.out.println(shelter);
		
		for(int i = 0; i < (total/2 - 1);i++) {
			Dog d = shelter.dequeueDog();
			System.out.println(d);
		}
		
		Animal a = shelter.dequeueAny();
		System.out.println("Any animal: " + a);
		
		for(int i = 0; i < (total/2 - 1);i++) {
			Dog d = shelter.dequeueDog();
			System.out.println(d);
		}
		
		a = shelter.dequeueAny();
		System.out.println("Any animal: " + a);
	}

	private static abstract class Animal {
		private String name;
		private int order;

		public Animal (int order, String name) {
			this.order = order;
			this.name = name;
		}
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		public boolean isBefore(Animal other) {
			return this.order < other.order;
		}
		
	}

	private static class Dog extends Animal {

		public Dog(int order, String name) {
			super(order, name);
		}
		@Override
		public String toString() {
			return "Dog: [name=" + getName() + ", order=" + getOrder() + "]";
		}
	}

	private static class Cat extends Animal {
		public Cat(int order, String name) {
			super(order, name);
		}
		
		@Override
		public String toString() {
			return "Cat: [name=" + getName() + ", order=" + getOrder() + "]";
		}
	}

	private static class AnimalShelter {
		private LinkedList<Dog> dogs;
		private LinkedList<Cat> cats;

		private AnimalShelter() {
			dogs = new LinkedList<Dog>();
			cats = new LinkedList<Cat>();
		}

		private void enqueue(Animal animal) {
			if (animal instanceof Dog) {
				dogs.add((Dog) animal);
			} else {
				cats.add((Cat) animal);
			}
		}

		private Dog dequeueDog() {
			Dog dog = dogs.size() > 0? dogs.removeFirst(): null;
			return dog;
		}

		private Cat dequeueCat() {
			Cat cat = cats.size() > 0? cats.removeFirst(): null;
			return cat;
		}

		private Animal dequeueAny() {
			if (dogs.size() == 0) {
				return dequeueCat();
			} else if (cats.size() == 0) {
				return dequeueDog();
			}

			Dog dog = dogs.getFirst();
			Cat cat = cats.getFirst();
			Animal animal = null;
			if (cat.isBefore(dog)) {
				animal = cats.removeFirst();
			} else {
				animal = dogs.removeFirst();
			}
			return animal;
		}

		@Override
		public String toString() {
			return "AnimalShelter [dogs=" + dogs + ", cats=" + cats + "]";
		}
	}
}
