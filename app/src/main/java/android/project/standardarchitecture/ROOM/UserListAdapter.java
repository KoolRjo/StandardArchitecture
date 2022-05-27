package android.project.standardarchitecture.ROOM;

import android.content.Context;
import android.project.standardarchitecture.R;
import android.project.standardarchitecture.ROOM.ENTITY.User;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends ListAdapter<User, UserListAdapter.DataViewHolder> {

    public UserListAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{
        private TextView tvId;
        private TextView tvName;
        private TextView tvAccount;
        private TextView tvPass;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tv_item_id);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvAccount = (TextView) itemView.findViewById(R.id.tv_item_account);
            tvPass = (TextView) itemView.findViewById(R.id.tv_item_pass);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        User user = getItem(position);
        holder.tvId.setText(String.valueOf(user.getUserId()));
        holder.tvName.setText(user.getUserName());
        holder.tvAccount.setText(user.getUserAccount());
        holder.tvPass.setText(user.getUserPass());
    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_user_items,parent,false);
        return new DataViewHolder(itemView);
    }

    public static class UserDiff extends DiffUtil.ItemCallback<User>{

        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return (oldItem.getUserId() == newItem.getUserId() && oldItem.getUserName().equals(newItem.getUserName()) &&
                    oldItem.getUserAccount().equals(newItem.getUserAccount()) && oldItem.getUserPass().equals(newItem.getUserPass()));
        }

    }
}
