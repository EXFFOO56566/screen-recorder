package com.tochy.screenrecorder.uiterfacec.mainactivities;

import java.lang.System;

/**
 * (tochy)
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0019H\u0014J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010\'\u001a\u00020\u0019H\u0003J\b\u0010(\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006+"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/mainactivities/MainActivity;", "Lcom/tochy/screenrecorder/uifile/DarkModeSwitchActivity;", "Lcom/tochy/screenrecorder/capturescrn/capturepermission/OverlayExplanationCallback;", "()V", "dataSource", "Lcom/afollestad/recyclical/datasource/SelectableDataSource;", "Lcom/tochy/screenrecorder/capturescrn/capturerecordings/Recording;", "mAdView", "Lcom/google/android/gms/ads/AdView;", "getMAdView", "()Lcom/google/android/gms/ads/AdView;", "setMAdView", "(Lcom/google/android/gms/ads/AdView;)V", "urlLauncher", "Lcom/tochy/screenrecorder/utilcmnuse/intents/UrlLauncher;", "getUrlLauncher", "()Lcom/tochy/screenrecorder/utilcmnuse/intents/UrlLauncher;", "urlLauncher$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/tochy/screenrecorder/uiterfacec/mainactivities/MainViewModel;", "getViewModel", "()Lcom/tochy/screenrecorder/uiterfacec/mainactivities/MainViewModel;", "viewModel$delegate", "admobAds", "", "checkForMediaProjectionAvailability", "invalidateToolbarElevation", "scrollY", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRecordingClicked", "recording", "onResume", "onShouldAskForOverlayPermission", "onShouldAskForStoragePermission", "setupGrid", "setupToolbar", "shareRecording", "Companion", "app_debug"})
public final class MainActivity extends com.tochy.screenrecorder.uifile.DarkModeSwitchActivity implements com.tochy.screenrecorder.capturescrn.capturepermission.OverlayExplanationCallback {
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy urlLauncher$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public com.google.android.gms.ads.AdView mAdView;
    private final com.afollestad.recyclical.datasource.SelectableDataSource<com.tochy.screenrecorder.capturescrn.capturerecordings.Recording> dataSource = null;
    private static final int DRAW_OVER_OTHER_APP_PERMISSION = 68;
    private static final int STORAGE_PERMISSION = 64;
    public static final com.tochy.screenrecorder.uiterfacec.mainactivities.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.tochy.screenrecorder.uiterfacec.mainactivities.MainViewModel getViewModel() {
        return null;
    }
    
    private final com.tochy.screenrecorder.utilcmnuse.intents.UrlLauncher getUrlLauncher() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.ads.AdView getMAdView() {
        return null;
    }
    
    public final void setMAdView(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.ads.AdView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void admobAds() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onShouldAskForOverlayPermission() {
    }
    
    private final void onShouldAskForStoragePermission() {
    }
    
    private final void setupToolbar() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setupGrid() {
    }
    
    private final void onRecordingClicked(com.tochy.screenrecorder.capturescrn.capturerecordings.Recording recording) {
    }
    
    private final void invalidateToolbarElevation(int scrollY) {
    }
    
    private final void shareRecording(com.tochy.screenrecorder.capturescrn.capturerecordings.Recording recording) {
    }
    
    private final void checkForMediaProjectionAvailability() {
    }
    
    public MainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/mainactivities/MainActivity$Companion;", "", "()V", "DRAW_OVER_OTHER_APP_PERMISSION", "", "STORAGE_PERMISSION", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}