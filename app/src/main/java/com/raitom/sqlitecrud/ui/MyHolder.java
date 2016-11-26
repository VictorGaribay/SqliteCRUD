package com.raitom.sqlitecrud.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.raitom.sqlitecrud.R;

/**
 * Created by raitom on 29/10/16.
 */

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView nameTxt;
    public TextView apellidotxt;
    public TextView dnitxt;
    public TextView direcciontxt;
    public TextView telefonotxt;
    public TextView dirTrabajotxt;
    public TextView ocupaciontxt;
    ItemClickListener itemClickListener;
    public MyHolder(View itemView) {
        super(itemView);
        //ASSIGN

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        apellidotxt= (TextView) itemView.findViewById(R.id.apellidoTxt);
        dnitxt= (TextView) itemView.findViewById(R.id.dniTxt);
        direcciontxt= (TextView) itemView.findViewById(R.id.direcciontxt);
        telefonotxt= (TextView) itemView.findViewById(R.id.telefonotxt);
        dirTrabajotxt = (TextView) itemView.findViewById(R.id.dirtrabajoTxt);
        ocupaciontxt= (TextView) itemView.findViewById(R.id.ocupaciontxt);
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }
}
