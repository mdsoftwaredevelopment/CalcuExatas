package mdsoftware.development.calcumath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Menu extends AppCompatActivity {
    public static InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        MobileAds.initialize(this, "ca-app-pub-7164742797981159~2767280446");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7164742797981159/8354293826");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
    public void math(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    Intent intent = new Intent(getApplicationContext(), matematica.class);
                    startActivity(intent);
                }

            });
        }
    }
    public void fisica(View view){
        Toast.makeText(Menu.this,"Este menu ainda não disponível ",Toast.LENGTH_SHORT).show();
    }
    public void quim(View view){
        Toast.makeText(Menu.this,"Este menu ainda não disponível ",Toast.LENGTH_SHORT).show();
    }
    public void cript(View view){
        Toast.makeText(Menu.this,"Este menu ainda não disponível ",Toast.LENGTH_SHORT).show();
    }
}
