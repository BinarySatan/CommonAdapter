#CommonAdapter
一个通用的 adapter, 只支持RecyclerView、多布局.非常方便使用.
 

##Use

### dependency



### normal adapter

	mRecyclerView.setAdapter(new BaseAdapter<String>(this, R.layout.item_layout, mDatas) {
			// 绑定数据
            @Override
            public void updateUI(BaseHolder holder, int position, String data) {
                holder.setText(R.id.tv, data);
            }
			// 如果你想要监听, 可以覆写 setListener()
			@Override
            public void setListener(final BaseHolder holder, final List<String> data) {
                holder.getView(R.id.tv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, data.get(holder.getAdapterPosition()), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


### multiLayoutAdapter
       mRecyclerView.setAdapter(new MultiLayoutAdapter<String>(this, mDatas) {
            @Override
            public int multiLayout(int position) {
                // 这里根据 自己需求, 来决定返回什么布局
                if (position == 0 || position == 2 || position == 4)
                    return R.layout.item_layout;
                return R.layout.item_layout1;
            }

            @Override
            public void updateMuiltUI(BaseHolder holder, int position, List<String> data) {
                if (R.layout.item_layout == getLayoutId(holder)) {
                    holder.setText(R.id.tv, "哈哈");
                } else {
                    holder.setText(R.id.tv, "嘎嘎");
                }
            }
			// 如果不想设置监听, 不重写即可.
            @Override
            public void setListener(final BaseHolder holder, final List<String> data) {
                holder.getView(R.id.tv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, data.get(holder.getAdapterPosition()), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    
## THANKS

* [https://github.com/hongyangAndroid/baseAdapter](https://github.com/hongyangAndroid/baseAdapter "https://github.com/hongyangAndroid/baseAdapter")