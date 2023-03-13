package com.tochy.screenrecorder.uiterfacec.mainactivities;

import java.lang.System;

/**
 * The view model/presenter for the [MainActivity].
 *
 * (@tochy)
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B[\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0002\u0010\u0017J\u0014\u0010-\u001a\u00020.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*J\u0006\u0010/\u001a\u00020#J\b\u00100\u001a\u00020#H\u0007J\u0012\u0010&\u001a\f\u0012\b\u0012\u00060\'j\u0002`(01H\u0007J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d03H\u0007J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020\u001603H\u0007J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d03H\u0007J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d03H\u0007J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020#01H\u0007J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020#01H\u0007J\b\u00109\u001a\u00020#H\u0007J\u0014\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*03H\u0007J\b\u0010;\u001a\u00020#H\u0007J\u0006\u0010<\u001a\u00020#J\b\u0010=\u001a\u00020.H\u0007J\u000e\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\u0016R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010#0#0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010#0#0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010&\u001a\u001a\u0012\u0016\u0012\u0014 $*\n\u0018\u00010\'j\u0004\u0018\u0001`(0\'j\u0002`(0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/mainactivities/MainViewModel;", "Lcom/tochy/screenrecorder/uiterfacec/ScopeViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "notifications", "Lcom/tochy/screenrecorder/notifictn/Notifications;", "permissionChecker", "Lcom/tochy/screenrecorder/utilcmnuse/permissions/PermissionChecker;", "captureEngine", "Lcom/tochy/screenrecorder/capturescrn/captureengine/CaptureEngine;", "recordingManager", "Lcom/tochy/screenrecorder/capturescrn/capturerecordings/RecordingManager;", "recordingScanner", "Lcom/tochy/screenrecorder/capturescrn/capturerecordings/RecordingScanner;", "serviceController", "Lcom/tochy/screenrecorder/capturescrn/captureservice/ServiceController;", "overlayManager", "Lcom/tochy/screenrecorder/capturescrn/captureoverlay/OverlayManager;", "alwaysShowNotificationPref", "Lcom/afollestad/rxkprefs/Pref;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/tochy/screenrecorder/notifictn/Notifications;Lcom/tochy/screenrecorder/utilcmnuse/permissions/PermissionChecker;Lcom/tochy/screenrecorder/capturescrn/captureengine/CaptureEngine;Lcom/tochy/screenrecorder/capturescrn/capturerecordings/RecordingManager;Lcom/tochy/screenrecorder/capturescrn/capturerecordings/RecordingScanner;Lcom/tochy/screenrecorder/capturescrn/captureservice/ServiceController;Lcom/tochy/screenrecorder/capturescrn/captureoverlay/OverlayManager;Lcom/afollestad/rxkprefs/Pref;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "emptyViewVisibility", "Landroidx/lifecycle/MutableLiveData;", "fabColorRes", "", "fabEnabled", "fabIconRes", "fabTextRes", "needOverlayPermission", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "needStoragePermission", "onError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "recordings", "", "Lcom/tochy/screenrecorder/capturescrn/capturerecordings/Recording;", "wantToStartCapture", "deleteRecordings", "Lkotlinx/coroutines/Job;", "fabClicked", "invalidateFab", "Lio/reactivex/Observable;", "onFabColorRes", "Landroidx/lifecycle/LiveData;", "onFabEnabled", "onFabIconRes", "onFabTextRes", "onNeedOverlayPermission", "onNeedStoragePermission", "onPause", "onRecordings", "onResume", "permissionGranted", "refreshRecordings", "setFabEnabled", "enabled", "app_debug"})
public final class MainViewModel extends com.tochy.screenrecorder.uiterfacec.ScopeViewModel implements androidx.lifecycle.LifecycleObserver {
    private io.reactivex.disposables.CompositeDisposable disposables;
    private boolean wantToStartCapture;
    private final io.reactivex.subjects.PublishSubject<kotlin.Unit> needStoragePermission = null;
    private final io.reactivex.subjects.PublishSubject<kotlin.Unit> needOverlayPermission = null;
    private final io.reactivex.subjects.PublishSubject<java.lang.Exception> onError = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.tochy.screenrecorder.capturescrn.capturerecordings.Recording>> recordings = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> emptyViewVisibility = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> fabColorRes = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> fabIconRes = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> fabTextRes = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> fabEnabled = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final com.tochy.screenrecorder.notifictn.Notifications notifications = null;
    private final com.tochy.screenrecorder.utilcmnuse.permissions.PermissionChecker permissionChecker = null;
    private final com.tochy.screenrecorder.capturescrn.captureengine.CaptureEngine captureEngine = null;
    private final com.tochy.screenrecorder.capturescrn.capturerecordings.RecordingManager recordingManager = null;
    private final com.tochy.screenrecorder.capturescrn.capturerecordings.RecordingScanner recordingScanner = null;
    private final com.tochy.screenrecorder.capturescrn.captureservice.ServiceController serviceController = null;
    private final com.tochy.screenrecorder.capturescrn.captureoverlay.OverlayManager overlayManager = null;
    private final com.afollestad.rxkprefs.Pref<java.lang.Boolean> alwaysShowNotificationPref = null;
    
    /**
     * Emits when recordings are received to populate the main grid.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.CheckResult()
    public final androidx.lifecycle.LiveData<java.util.List<com.tochy.screenrecorder.capturescrn.capturerecordings.Recording>> onRecordings() {
        return null;
    }
    
    /**
     * Emits when the FAB's background color should be changed.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.CheckResult()
    public final androidx.lifecycle.LiveData<java.lang.Integer> onFabColorRes() {
        return null;
    }
    
    /**
     * Emits when the FAB's icon should be changed.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.CheckResult()
    public final androidx.lifecycle.LiveData<java.lang.Integer> onFabIconRes() {
        return null;
    }
    
    /**
     * Emits when the FAB's text should be changed.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.CheckResult()
    public final androidx.lifecycle.LiveData<java.lang.Integer> onFabTextRes() {
        return null;
    }
    
    /**
     * Emits when the FAB's enabled state should be changed.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.CheckResult()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> onFabEnabled() {
        return null;
    }
    
    /**
     * Emits when the app needs permission to write external storage.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.CheckResult()
    public final io.reactivex.Observable<kotlin.Unit> onNeedStoragePermission() {
        return null;
    }
    
    /**
     * Emits when the app needs system overlay permissions.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.CheckResult()
    public final io.reactivex.Observable<kotlin.Unit> onNeedOverlayPermission() {
        return null;
    }
    
    /**
     * Emits when an error occurs that the user should see.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.CheckResult()
    public final io.reactivex.Observable<java.lang.Exception> onError() {
        return null;
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_RESUME)
    public final void onResume() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
    }
    
    /**
     * Refreshes recordings and notifies the respective live data values.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.VisibleForTesting(otherwise = androidx.annotation.VisibleForTesting.PRIVATE)
    public final kotlinx.coroutines.Job refreshRecordings() {
        return null;
    }
    
    /**
     * Deletes recordings' files and content provider entries - refreshes recordings
     * afterwards, causing an emission to [onRecordings].
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteRecordings(@org.jetbrains.annotations.NotNull()
    java.util.List<com.tochy.screenrecorder.capturescrn.capturerecordings.Recording> recordings) {
        return null;
    }
    
    /**
     * Call when the FAB is tapped - asking for any required permissions and starting screen capture.
     */
    public final void fabClicked() {
    }
    
    /**
     * Notifies that a permission was granted, trying [fabClicked] again if that's what caused
     * a permission request.
     */
    public final void permissionGranted() {
    }
    
    @androidx.annotation.VisibleForTesting(otherwise = androidx.annotation.VisibleForTesting.PRIVATE)
    public final void invalidateFab() {
    }
    
    @org.jetbrains.annotations.TestOnly()
    public final void setFabEnabled(boolean enabled) {
    }
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher mainDispatcher, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull()
    com.tochy.screenrecorder.notifictn.Notifications notifications, @org.jetbrains.annotations.NotNull()
    com.tochy.screenrecorder.utilcmnuse.permissions.PermissionChecker permissionChecker, @org.jetbrains.annotations.NotNull()
    com.tochy.screenrecorder.capturescrn.captureengine.CaptureEngine captureEngine, @org.jetbrains.annotations.NotNull()
    com.tochy.screenrecorder.capturescrn.capturerecordings.RecordingManager recordingManager, @org.jetbrains.annotations.NotNull()
    com.tochy.screenrecorder.capturescrn.capturerecordings.RecordingScanner recordingScanner, @org.jetbrains.annotations.NotNull()
    com.tochy.screenrecorder.capturescrn.captureservice.ServiceController serviceController, @org.jetbrains.annotations.NotNull()
    com.tochy.screenrecorder.capturescrn.captureoverlay.OverlayManager overlayManager, @org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.Boolean> alwaysShowNotificationPref) {
        super(null);
    }
}