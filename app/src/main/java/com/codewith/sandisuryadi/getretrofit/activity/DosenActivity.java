package com.codewith.sandisuryadi.getretrofit.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codewith.sandisuryadi.getretrofit.R;
import com.codewith.sandisuryadi.getretrofit.adapter.DosenAdapter;
import com.codewith.sandisuryadi.getretrofit.util.api.BaseApiService;
import com.codewith.sandisuryadi.getretrofit.util.api.UtilsApi;
import com.codewith.sandisuryadi.getretrofit.model.ResponseDosen;
import com.codewith.sandisuryadi.getretrofit.model.SemuadosenItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenActivity extends AppCompatActivity {
    @BindView(R.id.rvDosen)
    RecyclerView rvDosen;
    ProgressDialog loading;

    Context mContext;
    List<SemuadosenItem> semuadosenItemList = new ArrayList<>();
    DosenAdapter dosenAdapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);

        getSupportActionBar().setTitle("Dosen");

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        dosenAdapter = new DosenAdapter(this, semuadosenItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvDosen.setLayoutManager(mLayoutManager);
        rvDosen.setItemAnimator(new DefaultItemAnimator());

        getResultListDosen();
    }

    // Fungsi ini untuk mengambil data dari API Server GET.
    private void getResultListDosen() {
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);

        mApiService.getSemuaDosen().enqueue(new Callback<ResponseDosen>() {
            @Override
            public void onResponse(Call<ResponseDosen> call, Response<ResponseDosen> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<SemuadosenItem> semuadosenItems = response.body().getSemuadosen();

                    rvDosen.setAdapter(new DosenAdapter(mContext, semuadosenItems));
                    dosenAdapter.notifyDataSetChanged();

                }else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal Mengambil Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDosen> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
