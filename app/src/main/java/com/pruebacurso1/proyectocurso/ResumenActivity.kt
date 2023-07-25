package com.pruebacurso1.proyectocurso

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class ResumenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    private  lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val mToolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        mToolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(mToolbar)
        supportActionBar?.title="Resumen"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this,drawer,mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.profile -> {
                // Se seleccionó la opción de "Resumen" en el menú
                // Abrir la actividad ResumenActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.resumecourse -> {
                // Aquí se seleccionó la opción de "Perfil" en el menú
                // Reiniciar la actividad
                recreate()
            }
            R.id.rulescourse-> {
                // Se seleccionó la opción de "Resumen" en el menú
                // Abrir la actividad ResumenActivity
                val intent = Intent(this, RulesActivity::class.java)
                startActivity(intent)
            }
            R.id.topicsguideline-> {

                val intent = Intent(this, TopicsGuideLineActivity::class.java)
                startActivity(intent)
            }
            R.id.sesions-> {

                val intent = Intent(this, SessionActivity::class.java)
                startActivity(intent)
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}