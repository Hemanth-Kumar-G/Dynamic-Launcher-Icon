package com.hemanth.dynamilaunchericon

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var appIconNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btnOne).setOnClickListener {
            packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".One"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP)
            appIconNumber = 1
            unInstallOldICon(appIconNumber)
            startActivity(Intent(this, SecondActivity::class.java))
        }

        findViewById<Button>(R.id.btnTwo).setOnClickListener {
            packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".Two"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP)
            appIconNumber = 2
            unInstallOldICon(appIconNumber)
            startActivity(Intent(this, SecondActivity::class.java))
        }

        findViewById<Button>(R.id.btnThree).setOnClickListener {
            packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".Three"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP)
            appIconNumber = 3
            unInstallOldICon(appIconNumber)
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }

    override fun onStop() {
//        unInstallOldICon(appIconNumber)
        super.onStop()
    }

    private fun unInstallOldICon(appIconNumber: Int) {
        when (appIconNumber) {
            1 -> {
                packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".Two"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".Three"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
            }
            2 -> {
                packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".One"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".Three"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
            }
            3 -> {
                packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".One"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(applicationContext.packageName, applicationContext.packageName + ".Two"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
            }
            else -> Unit
        }

    }
}
