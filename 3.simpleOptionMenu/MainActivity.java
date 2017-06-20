package com.example.feez.simple_option_menu;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //private Spinner actionBarSpinner;
    private ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//main
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("");
        //toolbar.setBackgroundColor(Color.rgb(0, 0, 0));
        toolbar.setBackgroundColor(Color.GRAY);
        toolbar.setTitleTextColor(Color.WHITE);   //@string/app_name
        toolbar.setSubtitle("  Menu");
        toolbar.setSubtitleTextColor(Color.WHITE);
        toolbar.setLogo(R.drawable.game);
        setSupportActionBar(toolbar); //show toobal and enble src/menu+.xml function
        //end toolbar


        //textbox
        EditText editText = (EditText) findViewById(R.id.editText);
        registerForContextMenu(editText);  //Assign context Menu to editText

        //ContextualActionBar assign with image
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        //image wait action
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (mActionMode == null) {
                    //MainActivity.this.startActionMode(new ActionBarCallBack());
                    //mActionMode =  startActionMode(callback);
                    Toast.makeText(getBaseContext(),"Hello world",Toast.LENGTH_SHORT).show();
                //}
            }
        });//end img

    }//main

    /*
    //------------- ContextualActionBar  action mode --------------------
    private ActionMode.Callback mCallback = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.contextual_actionbar, menu);
            mode.setTitle("...");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode,Menu menu){
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode am,MenuItem item){
            int id = item.getItemId();
            if(id == R.id.action_edit){
                //null
            }else if(id == R.id.action_share){
                //null
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode){
            mActionMode = null;
        }


    };//end action mode function
    */

    /*
    class ActionBarCallBack implements ActionMode.Callback {

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            mode.getMenuInflater().inflate(R.menu.contextual_actionbar, menu);
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub

            //mode.setTitle("CheckBox is Checked");
            return false;
        }

    }*/






    public boolean onCreateOptionsMenu(Menu menu){
        //menu bar generator
        getMenuInflater().inflate(R.menu.menu_main,menu);   //xml >> java : menu bar generator

        //spinner generator
        MenuItem menuItem = menu.findItem(R.id.action_spinner);
        final Spinner spinner = (Spinner) MenuItemCompat.getActionView(menuItem);
        //this.actionBarSpinner = spinner;
        String[] items = {"Menu","noodle"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,items);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // put code which recognize a selected element
                String selectItem = spinner.getSelectedItem().toString();
                if(selectItem.equals("Menu1")){
                    spinner.setSelection(0);
                    //Toast.makeText(getBaseContext(),"Hello",Toast.LENGTH_SHORT).show();
                }else if(selectItem.equals("noodle")){
                    spinner.setSelection(1);
                    Toast.makeText(getBaseContext(),"Hello world",Toast.LENGTH_SHORT).show();
                }

                selectItem = spinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        //end spinner bar
        return true;
    }

    @Override
    //menu bar action
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){  //ref to menu setting
            showpopupMenu();
            return true;
        }else if(id == R.id.action_help){ //ref to menu help
            menuHelp(item);
            //getActionBarSpinner();
            return true;
        }else if(id == R.id.action_search){ //ref to menu search
            showpopupMenu2();
            //menuSearch(item);
            return true;

            /*
            //sub menu : use edit_popup_menu.xml is better
        }else if(id == R.id.submenu_google){  //SUB MENU
            subGoogle(item);
            return true;
        }else if(id == R.id.submenu_youtube) {  //SUB MENU
            subYoutube(item);
            return true;*/
        }

        return super.onOptionsItemSelected(item);

    }//end menu bar action
    //------------------------ End menu bar ------------------------------


    //---------------------- popup menu zone ----------------------------------------
    //popup menu of edit
    private  void showpopupMenu(){
        View v = findViewById(R.id.action_settings);
        PopupMenu popupmenu = new PopupMenu(this,v);
        popupmenu.inflate(R.menu.edit_popup_menu); //xml >> java
        popupmenu.show();

        //popup wait and action
        popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.set_date){
                    setDate();
                    return true;
                }else if(id == R.id.set_month){
                    setMonth();
                    return true;
                }
                return false;
            }
        });
    }
    //End popup menu


    //popup menu of search
    private  void showpopupMenu2(){
        View v = findViewById(R.id.action_settings);
        PopupMenu popupmenu = new PopupMenu(this,v);
        popupmenu.inflate(R.menu.search_popup_menu); //xml >> java
        popupmenu.show();

        //popup wait and action
        popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.find_google){
                    findGoogle();
                    return true;
                }else if(id == R.id.find_yahoo){
                    findYahoo();
                    return true;
                }
                return false;
            }
        });
    }
    //------------------ End popup menu ---------------------------------


    //------------------  pop up function ----------------------------------
    private void setDate(){
        Toast.makeText(getBaseContext(),"Set Date",Toast.LENGTH_SHORT).show();
    }

    private void setMonth(){
        Toast.makeText(getBaseContext(),"Set Month",Toast.LENGTH_SHORT).show();
    }

    private void findGoogle(){
        Toast.makeText(getBaseContext(),"Google",Toast.LENGTH_SHORT).show();
    }

    private void findYahoo(){
        Toast.makeText(getBaseContext(),"Yahoo",Toast.LENGTH_SHORT).show();
    }
    //------------------  End pop up function ----------------------------------





    //---------------- menu function -----------------------------------------
    //fuction menuSetting
    private void menuSetting(MenuItem item){
        Toast.makeText(getBaseContext(),"menuSetting",Toast.LENGTH_SHORT).show();
    }


    //fuction menuHelp
    private void menuHelp(MenuItem item){
        Toast.makeText(getBaseContext(),"find Help function in manual website Thank you and welcome to use my app.",Toast.LENGTH_SHORT).show();
    }

    //fuction menuSearch
    private void menuSearch(MenuItem item){
        //Toast.makeText(getBaseContext(),"menuSearch",Toast.LENGTH_SHORT).show();
    }

    //fuction subGoogle
    private void subGoogle(MenuItem item){
        Toast.makeText(getBaseContext(),"Google",Toast.LENGTH_SHORT).show();
    }

    //fuction subYoutube
    private void subYoutube(MenuItem item){
        Toast.makeText(getBaseContext(),"Search",Toast.LENGTH_SHORT).show();
    }//end menu
    //---------------- End menu function -----------------------------------------






    //---------------------   context menu main ---------------------------------------------
    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo info){
        super.onCreateContextMenu(contextMenu,v,info);
        //contextMenu
                //.setHeaderTitle("Select process")
                //.setHeaderIcon(R.drawable.game);

        //แปลง xml เป็น java
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit,contextMenu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.menu_cut){
            return true;
        }
        if(id == R.id.menu_copy){
            return true;
        }
        if(id == R.id.menu_paste){
            return true;
        }
        return super.onContextItemSelected(item);
    }
    //-------------------     end context menu ---------------------------------------------

    /*
    private  void getActionBarSpinner(){
        String item = this.actionBarSpinner.getSelectedItem().toString();
    }*/






}//END SCCOPE


