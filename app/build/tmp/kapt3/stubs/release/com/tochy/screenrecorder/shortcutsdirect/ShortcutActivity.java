package com.tochy.screenrecorder.shortcutsdirect;

import java.lang.System;

/**
 * A relay for app shortcuts - has no UI, just links to the background service.
 *
 * (@tochy)
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tochy/screenrecorder/shortcutsdirect/ShortcutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "captureEngine", "Lcom/tochy/screenrecorder/capturescrn/captureengine/CaptureEngine;", "getCaptureEngine", "()Lcom/tochy/screenrecorder/capturescrn/captureengine/CaptureEngine;", "captureEngine$delegate", "Lkotlin/Lazy;", "serviceController", "Lcom/tochy/screenrecorder/capturescrn/captureservice/ServiceController;", "getServiceController", "()Lcom/tochy/screenrecorder/capturescrn/captureservice/ServiceController;", "serviceController$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"})
public final class ShortcutActivity extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy captureEngine$delegate = null;
    private final kotlin.Lazy serviceController$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.tochy.screenrecorder.capturescrn.captureengine.CaptureEngine getCaptureEngine() {
        return null;
    }
    
    private final com.tochy.screenrecorder.capturescrn.captureservice.ServiceController getServiceController() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public ShortcutActivity() {
        super();
    }
}