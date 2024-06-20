package ru.netology.repo;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Товар с id = " + id + " не существует");
    }
}
