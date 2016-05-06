package martinholtsmeier.ee.todoapp;

/**
 * Created by Holtsmeier on 18.04.2016.
 */
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomListAdapter extends BaseAdapter {
    private ArrayList<Task> list;
    //private ArrayList<String> listValues = null;
    private LayoutInflater inflater = null;

    //public CustomListAdapter(Context context, ArrayList<String> listValues)
    public CustomListAdapter(Context context, ArrayList<Task> list){
        this.list = list;

        inflater = LayoutInflater.from(context);
        //this.listValues = listValues;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ListItemViewHolder holder = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ListItemViewHolder();
            holder.image = (ImageView)convertView.findViewById(R.id.list_item_image);
            holder.description = (TextView) convertView.findViewById(R.id.list_item_description);
            //holder.date = (TextView) convertView.findViewById(R.id.list_item_date);
            holder.createdDate = (TextView) convertView.findViewById(R.id.list_item_date);
            convertView.setTag(holder);
            holder.buttonDelete = (Button) convertView.findViewById(R.id.delete_btn);
            holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });
        } else {
            holder = (ListItemViewHolder) convertView.getTag();
        }

        //holder.description.setText(listValues.get(position));
        //holder.description.setText(listValues.get(position));

        Task task = list.get(position);
        holder.description.setText(task.getDescription());
        holder.createdDate.setText(task.getCreatedDate().toString());
        return  convertView;
    }
    class ListItemViewHolder{
        private ImageView image;
        private TextView description;
        private TextView date;
        private Button buttonDelete;
        private TextView createdDate;

    }
    @Override
    public int getCount() {
        //return listValues.size();
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        //return listValues.get(position);
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}

