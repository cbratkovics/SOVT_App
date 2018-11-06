package com.bignerdranch.android.sovt_app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

public class PicoMap extends AppCompatActivity {

    PDFView mPDFView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        mPDFView = (PDFView) findViewById(R.id.pdf_viewer);

        if(getIntent() != null) {
            String viewType = getIntent().getStringExtra("ViewType");
            if(viewType.equals("assets")) {
                mPDFView.fromAsset("Pico_Map.pdf")
                        .password(null) // If password is needed
                        .defaultPage(0) //Open default page, can be remembered from last time
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(true) //Double tap to zoom
                        .onDraw(new OnDrawListener() {
                            @Override
                            public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                //Code here if you want to do something
                            }
                        })
                        .onDrawAll(new OnDrawListener() {
                            @Override
                            public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                //Code here if you want to do something
                            }
                        })
                        .onPageError(new OnPageErrorListener() {
                            @Override
                            public void onPageError(int page, Throwable t) {
                                Toast.makeText(PicoMap.this, "Error while opening page " + page, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {
                                //Code here if you want to do something
                            }
                        })
                        .onTap(new OnTapListener() {
                            @Override
                            public boolean onTap(MotionEvent e) {
                                return true;
                            }
                        })
                        .onRender(new OnRenderListener() {
                            @Override
                            public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                mPDFView.fitToWidth(); //Fixed screen size
                            }
                        })
                        .enableAnnotationRendering(true)
                        .invalidPageColor(Color.WHITE)
                        .load();

            }
        }
    }
}