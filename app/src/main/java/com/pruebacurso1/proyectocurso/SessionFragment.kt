package com.pruebacurso1.proyectocurso

// SessionsFragment.kt
import Session
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SessionsFragment : Fragment() {

    private val sessionList = mutableListOf<Session>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sessions, container, false)

        // Populate the sessionList with some sample data
        sessionList.add(Session("Sesión 1", "Descripción de la sesión 1", false))
        sessionList.add(Session("Sesión 2", "Descripción de la sesión 2", false))
        sessionList.add(Session("Sesión 3", "Descripción de la sesión 3", false))
        // Add more sessions as needed

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = SessionAdapter(sessionList)

        return view
    }

    private inner class SessionAdapter(private val sessions: List<Session>) :
        RecyclerView.Adapter<SessionAdapter.SessionViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.session_card, parent, false)
            return SessionViewHolder(view)
        }

        override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
            val session = sessions[position]
            holder.textTitle.text = session.title
            holder.textDescription.text = session.description
            holder.checkboxStatus.isChecked = session.isCompleted
        }

        override fun getItemCount(): Int {
            return sessions.size
        }

        inner class SessionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textTitle: TextView = itemView.findViewById(R.id.textTitle)
            val textDescription: TextView = itemView.findViewById(R.id.textDescription)
            val checkboxStatus: CheckBox = itemView.findViewById(R.id.checkboxStatus)
        }
    }
}
