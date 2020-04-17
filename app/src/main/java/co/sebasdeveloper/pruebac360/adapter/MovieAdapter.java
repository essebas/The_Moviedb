package co.sebasdeveloper.pruebac360.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import co.sebasdeveloper.pruebac360.R;
import co.sebasdeveloper.pruebac360.databinding.MovieBinding;
import co.sebasdeveloper.pruebac360.model.MovieListModel;
import co.sebasdeveloper.pruebac360.model.MovieModel;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviewView>{

    private Context context;
    private LayoutInflater layoutInflater;
    private MovieListModel movieListModel;
    private ArrayList<MovieModel> list;

    public MovieAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public MovieAdapter(Context context, MovieListModel movieListModel) {
        this.context = context;
        this.movieListModel = movieListModel;
        this.list = movieListModel.getResults();
    }

    @NonNull
    @Override
    public MoviewView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        MovieBinding movieBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_movie_layout, parent, false);
        return new MoviewView(parent, movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviewView holder, int position) {
        MovieModel movieModel = list.get(position);
        holder.ratingBar.setRating((float)movieModel.getVote_average_scale5());
        boolean isExpanded = movieModel.isExpanded();
        holder.constraintLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.bind(movieModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<MovieModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class MoviewView extends RecyclerView.ViewHolder{

        private RatingBar ratingBar;
        private MovieBinding movieBinding;
        private ConstraintLayout constraintLayout;
        private LinearLayout principal;

        public MoviewView(@NonNull View itemView, MovieBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;
            initializeComponents();
        }

        public void bind(MovieModel movieModel){
            this.movieBinding.setMovie(movieModel);
            this.movieBinding.executePendingBindings();
        }

        public MovieBinding getMovieBinding() {
            return movieBinding;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        private void initializeComponents(){
            this.ratingBar = movieBinding.getRoot().findViewById(R.id.rating_average);
            this.constraintLayout = movieBinding.getRoot().findViewById(R.id.details);
            this.principal = movieBinding.getRoot().findViewById(R.id.principal);

            this.principal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieModel movieModel = list.get(getAdapterPosition());
                    movieModel.setExpanded(!movieModel.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

    }

}
