package com.maslovss.oodesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.maslovss.oodesign.model.Event;
import com.maslovss.oodesign.model.EventViewHolder;
import com.maslovss.oodesign.model.EventViewHolderFactory;
import com.maslovss.oodesign.model.Task;
import com.maslovss.oodesign.model.TaskViewHolderFactory;
import com.maslovss.oodesign.model.TaskViewHolderNoCheckFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StringViewHolder textViewHolder;
    EventViewHolder  eventViewHolder = (EventViewHolder)  new EventViewHolderFactory().createViewHolder();
    RecyclerViewPresenter<Event> rvPresenter;
    List<Task> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initTestText();

        //List<Event> list = getEvents();
        //initRecyclerView(list, R.id.rv);

        taskList.clear();
        taskList.add( new Task("Надо купить", "Я") );
        taskList.add( new Task(true , "Заправка", "Я") );
        taskList.add( new Task("Сварить борщ", "Жена") );
        for(int i =0;i<1000;i++)
            taskList.add( new Task( i % 2 == 1 , "Пойти в садик", "Дима") );
        initRecyclerView2(taskList, R.id.rv);



        //Event ev = new Event("HELLO" , "HELL");
        //showEvent(ev, R.id.event_title, R.id.event_message);

        initFloatActoinButton();
    }

    private void initRecyclerView(List<Event> list, int recyclerViewResID) {
        RecyclerView rv = (RecyclerView) findViewById(recyclerViewResID);
        rvPresenter = new RecyclerViewPresenter(this , rv , list ,
                            R.layout.event_layout ,
                            new int[] {R.id.event_title , R.id.event_message} ,
                            new EventViewHolderFactory());
        rvPresenter.setLayoutManager(new GridLayoutManager(this, 4));
        rvPresenter.present();
        rvPresenter.setSwipe(true);
    }

    private void initRecyclerView2(List<Task> list, int recyclerViewResID) {

        RecyclerView rv = (RecyclerView) findViewById(recyclerViewResID);

        rvPresenter = new RecyclerViewPresenter(this , rv , list ,
                R.layout.task_item ,
                new int[] { R.id.task_item_isDone , R.id.task_item_title , R.id.task_item_worker} ,
                new TaskViewHolderFactory());

        //rvPresenter.setLayoutManager(new GridLayoutManager(this , 4));
        rvPresenter.present();
        rvPresenter.setSwipe(true);
    }

    private void initRecyclerViewNoCkeckBox(List<Task> list, int recyclerViewResID) {

        RecyclerView rv = (RecyclerView) findViewById(recyclerViewResID);

        rvPresenter = new RecyclerViewPresenter(this , rv , list ,
                R.layout.task_item_no_ckeckbox ,
                new int[] { R.id.task_item_title , R.id.task_item_worker} ,
                new TaskViewHolderNoCheckFactory());

        //rvPresenter.setLayoutManager(new GridLayoutManager(this , 4));
        rvPresenter.present();
        rvPresenter.setSwipe(true);
    }


    private void initFloatActoinButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRecyclerViewNoCkeckBox(taskList , R.id.rv);
            }
        });
    }

    private void showEvent(Event ev, int event_title, int event_message) {
        eventViewHolder.bind(getWindow().getDecorView(), event_title, event_message);
        eventViewHolder.show( ev);
    }


    @NonNull
    private List<Event> getEvents() {
        List<Event> list = new ArrayList<>();
        list.add( new Event("1" , "2"));
        list.add( new Event("11" , "22"));
        for(int i =0 ; i < 1000 ; i++)
            list.add( new Event(Integer.toString(i)  , Integer.toString(i * 100)));
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
