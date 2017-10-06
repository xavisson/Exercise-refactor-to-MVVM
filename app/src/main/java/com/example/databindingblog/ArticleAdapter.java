package com.example.databindingblog;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.databindingblog.databinding.ArticleItemBinding;

import java.util.List;

/**
 * Created by milan on 17.8.16.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.BindingHolder> {

    private List<Article> articleList;
    private Context mContext;

    public ArticleAdapter(List<Article> mArticles, Context context) {
        this.articleList = mArticles;
        this.mContext = context;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ArticleItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.article_item, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ArticleItemBinding binding = holder.binding;
        binding.setArticle(articleList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ArticleItemBinding binding;

        public BindingHolder(ArticleItemBinding binding) {
            super(binding.contactCard);
            this.binding = binding;
        }
    }
}
