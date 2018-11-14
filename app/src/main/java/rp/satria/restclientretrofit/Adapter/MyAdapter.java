package rp.satria.restclientretrofit.Adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rp.satria.restclientretrofit.Model.Pembelian;
import rp.satria.restclientretrofit.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Pembelian> mPembelianList;

    public MyAdapter(List<Pembelian> pembelianList) {
        mPembelianList = pembelianList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextViewIdPembelian.setText("Id Pembelian :  " + mPembelianList.get(position)
                .getId_pembelian());
        holder.mTextViewIdPembeli.setText("Id Pembeli :  " + mPembelianList.get(position)
                .getId_pembeli());
        holder.mTextViewIdTiket.setText("Id Tiket :  " + mPembelianList.get(position).getId_tiket
                ());
        holder.mTextViewTanggal.setText("Tanggal Beli :  " + mPembelianList.get(position)
                .getTanggal_beli());
        holder.mTextViewTotalHarga.setText("Total Harga :  " + String.valueOf(mPembelianList.get
                (position).getTotal_harga()));
    }

    @Override
    public int getItemCount() {
        return mPembelianList.size();
    }

    public class MyViewHolder extends ViewHolder {
        public TextView mTextViewIdPembelian, mTextViewIdPembeli, mTextViewTanggal,mTextViewIdTiket,mTextViewTotalHarga;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdPembelian = (TextView) itemView.findViewById(R.id.tvIdPembelian);
            mTextViewIdPembeli = (TextView) itemView.findViewById(R.id.tvIdPembeli);
            mTextViewTanggal = (TextView) itemView.findViewById(R.id.tvTanggalBeli);
            mTextViewIdTiket = (TextView) itemView.findViewById(R.id.tvIdTiket);
            mTextViewTotalHarga = (TextView) itemView.findViewById(R.id.tvTotalHarga);
        }
    }
}

