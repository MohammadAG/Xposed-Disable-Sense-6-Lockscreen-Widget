package com.mohammadag.disablesense6lockscreenwidget;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class XposedMod implements IXposedHookLoadPackage {
	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		if (!lpparam.packageName.equals("com.htc.lockscreen"))
			return;

		XposedHelpers.findAndHookMethod("com.htc.lockscreen.keyguard.KeyguardHostView",
				lpparam.classLoader, "addDefaultStatusWidget", int.class, XC_MethodReplacement.DO_NOTHING);
	}
}
