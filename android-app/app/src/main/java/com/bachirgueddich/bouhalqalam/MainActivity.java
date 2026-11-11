package com.bachirgueddich.bouhalqalam;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.webkit.WebResourceRequest;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
public class MainActivity extends Activity {
 private WebView web;
 private static final String HOME="https://gueddich46-lab.github.io/-bouh-alqalam/";
 @Override public void onCreate(Bundle state){super.onCreate(state);
 getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
 web=new WebView(this);setContentView(web);WebSettings s=web.getSettings();
 s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setMediaPlaybackRequiresUserGesture(true);
 web.setWebChromeClient(new WebChromeClient());
 web.setWebViewClient(new WebViewClient(){
 @Override public boolean shouldOverrideUrlLoading(WebView view,WebResourceRequest req){
 Uri u=req.getUrl();String host=u.getHost();
 if("https".equals(u.getScheme())&&"gueddich46-lab.github.io".equals(host)&&u.getPath().startsWith("/-bouh-alqalam/"))return false;
 try{startActivity(new Intent(Intent.ACTION_VIEW,u));}catch(Exception ignored){}return true;
 }});
 if(state==null)web.loadUrl(HOME);else web.restoreState(state);
 }
 @Override public void onBackPressed(){if(web!=null&&web.canGoBack())web.goBack();else super.onBackPressed();}
 @Override protected void onSaveInstanceState(Bundle out){web.saveState(out);super.onSaveInstanceState(out);}
 @Override protected void onDestroy(){if(web!=null)web.destroy();super.onDestroy();}
}