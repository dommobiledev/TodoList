package com.example.dominik.todolist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominik on 22/11/2017.
 */

public class TodoListFragment extends Fragment {
    private RecyclerView mTodoRecyclerView;
    TodoAdapter mTodoAdapter;

    @Override
    public void onCreate(Bundle savedIstanceState) {
        super.onCreate(savedIstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        mTodoRecyclerView = view.findViewById(R.id.todo_recycler_view);
        mTodoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ArrayList todos = new ArrayList<>();
        TodoModel todoModel = TodoModel.get(getContext());
        todos = todoModel.getTodos();

        if(mTodoAdapter == null) {
            mTodoAdapter = new TodoAdapter(todos);
            mTodoRecyclerView.setAdapter(mTodoAdapter);
        }else {
            mTodoAdapter.notifyDataSetChanged();
        }
    }

    public class TodoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Todo mTodo;
        private TextView mTextViewTitle, mTextViewDate;

        public TodoHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_todo, parent, false));
            itemView.setOnClickListener(this);

            mTextViewTitle = itemView.findViewById(R.id.todo_title);
            mTextViewDate = itemView.findViewById(R.id.todo_date);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mTodo.getTitle() + "clicked", Toast.LENGTH_SHORT)
                    .show();

            Intent intent = TodoActivity.newIntent(getActivity(), mTodo.getId());
            startActivity(intent);
        }

        public void bind(Todo todo) {
            mTodo = todo;
            mTextViewTitle.setText(mTodo.getTitle());
            mTextViewDate.setText(mTodo.getDate().toString());
        }
    }

    public class TodoAdapter extends RecyclerView.Adapter<TodoListFragment.TodoHolder> {
        private List<Todo> mTodos;

        public TodoAdapter(List<Todo> todos) {
            mTodos = todos;
        }

        @Override
        public TodoListFragment.TodoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new TodoHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(TodoHolder holder, int position) {
            Todo todo = mTodos.get(position);
            holder.bind(todo);
        }

        @Override
        public int getItemCount() {
            return mTodos.size();
        }
    }
}
