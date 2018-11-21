package rp.satria.restclientretrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rp.satria.restclientretrofit.Adapter.PembeliAdapter;
import rp.satria.restclientretrofit.Model.GetPembeli;
import rp.satria.restclientretrofit.Model.Pembeli;
import rp.satria.restclientretrofit.Rest.ApiClient;
import rp.satria.restclientretrofit.Rest.ApiInterface;

public class LayarListPembeli extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    ApiInterface mApiInterface;
    FloatingActionButton btGet, btAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_list_pembeli);

        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        btGet = findViewById(R.id.btGet);
        btAddData = findViewById(R.id.btAddData);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<GetPembeli> mPembeliCall = mApiInterface.getPembeli();
                mPembeliCall.enqueue(new Callback<GetPembeli>() {
                    @Override
                    public void onResponse(Call<GetPembeli> call, Response<GetPembeli> response) {
                        Log.d("Get Pembeli",response.body().getStatus());
                        List<Pembeli> listPembeli = response.body().getResult();
                        mAdapter = new PembeliAdapter(listPembeli);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetPembeli> call, Throwable t) {
                        Log.d("Get Pembeli",t.getMessage());
                    }
                });
            }
        });

        btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LayarInsertPembeli.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {

            case R.id.menuTambahTransPembelian:
                mIntent = new Intent(this, LayarDetail.class);
                startActivity(mIntent);
                return true;

            case R.id.menuListPembeli:
                mIntent = new Intent(this, LayarListPembeli.class);
                startActivity(mIntent);
                return true;

            case R.id.menuInsertDataPembeli:
                Intent intent = new Intent(this, LayarInsertPembeli.class);
                startActivity(intent);
                return true;

            case R.id.menuListPembelian:
                mIntent = new Intent(this, MainActivity.class);
                startActivity(mIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

