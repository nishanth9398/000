package com.codechef.ffds;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessagesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.messages_activity, container, false);

        TextView noMatches = root.findViewById(R.id.no_matches);
        TextView noMessages = root.findViewById(R.id.no_messages);

        ArrayList<Integer> mList = new ArrayList<>();
        mList.add(R.drawable.re);
        mList.add(R.drawable.re);
        mList.add(R.drawable.re);
        mList.add(R.drawable.re);
        mList.add(R.drawable.re);

        if (mList.isEmpty())
            noMatches.setVisibility(View.VISIBLE);
        else
            noMatches.setVisibility(View.GONE);

        RecyclerView recyclerView = root.findViewById(R.id.matches_view);
        MatchAdapter adapter = new MatchAdapter(requireContext(), mList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(position -> {

        });

        ArrayList<Messages> list = new ArrayList<>();
        list.add(new Messages("Hey", R.drawable.re, "Goku"));
        list.add(new Messages("Yo", R.drawable.re, "Naruto"));
        list.add(new Messages("Hey", R.drawable.re, "Saitama"));
        list.add(new Messages("Buri Buri", R.drawable.re, "Shinchan"));
        list.add(new Messages("...", R.drawable.re, "Anonymous"));

        if (list.isEmpty())
            noMessages.setVisibility(View.VISIBLE);
        else
            noMessages.setVisibility(View.GONE);

        RecyclerView recyclerView1 = root.findViewById(R.id.messages_view);
        MessageAdapter messageAdapter = new MessageAdapter(getContext(), list);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView1.setAdapter(messageAdapter);

        messageAdapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(getActivity(), ChatActivity.class);
            intent.putExtra("Name", list.get(position).getName());
            startActivity(intent);
        });

        return root;
    }
}
