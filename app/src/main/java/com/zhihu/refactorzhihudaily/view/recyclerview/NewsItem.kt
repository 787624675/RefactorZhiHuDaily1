package com.zhihu.refactorzhihudaily.view.recyclerview

import android.content.Context
import android.content.Intent
import com.bumptech.glide.Glide
import com.wangzai.rvadapter.base.DelegateType
import com.wangzai.rvadapter.base.ViewHolder

import com.zhihu.refactorzhihudaily.model.RemixItem
import com.zhihu.refactorzhihudaily.view.DetailActivity
import kotlinx.android.synthetic.main.activity_splash.view.*
import kotlinx.android.synthetic.main.item_date.view.*
import kotlinx.android.synthetic.main.item_news.view.*
import org.jetbrains.anko.generated.appcompatV7.coroutines.R

class NewsItem : DelegateType<RemixItem> {
    override val itemViewLayoutId: Int
        get() = com.zhihu.refactorzhihudaily.R.layout.item_news

    override fun convert(context: Context, holder: ViewHolder, item: RemixItem, position: Int) {
        with(holder.itemView){
            news_title.setText(item.title)
            news_hint.setText(item.hint)
            Glide.with(context).load(item.imageUrl).into(news_image)
            setOnClickListener {
                var intent : Intent = Intent()
                intent.setClass(context, DetailActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("newsId",item.id)
                context.startActivity(intent)

            }
        }
    }

    override fun isItemViewType(item: RemixItem, position: Int): Boolean {
        return item.type == 3
    }

}