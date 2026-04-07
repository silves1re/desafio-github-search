package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = repositories[position]

        // @TODO 8 - Realizar o bind do viewHolder
        holder.name.text = repository.name

        // Click no Card (cv_car)
        holder.cardContainer.setOnClickListener {
            carItemLister(repository)
        }

        // Click no botão de Share (shared_option)
        holder.btnShare.setOnClickListener {
            btnShareLister(repository)
        }
    }

    // @TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // @TODO 10 - Implementar o ViewHolder para os repositorios
        val name: TextView = view.findViewById(R.id.repository_name)
        val btnShare: ImageButton = view.findViewById(R.id.shared_option)
        val cardContainer: CardView = view.findViewById(R.id.cv_car)
    }
}


