package com.example.dominik.todolist;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Dominik on 22/11/2017.
 */

public class TodoModel {
    private static TodoModel sTodoModel;
    private ArrayList<Todo> mTodoList;

    public static TodoModel get(Context context) {
        if(sTodoModel == null) {
            sTodoModel = new TodoModel(context);
        }
        return sTodoModel;
    }

    private TodoModel(Context context) {
        mTodoList = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            Todo todo = new Todo();
            todo.setTitle("Title" + i);
            todo.setDetail("Detail" + todo.getId().toString());
            todo.setComplete(false);

            mTodoList.add(todo);
        }
    }

    public Todo getTodo(UUID todoId) {
        for(Todo todo : mTodoList) {
            if(todo.getId().equals(todoId)) {
                return todo;
            }
        }
        return null;
    }

    public ArrayList<Todo> getTodos() {
        return mTodoList;
    }

    public void addTodo(Todo todo) {
        mTodoList.add(todo);
    }
}
