import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.test.myapplication.MenuCafe
import com.test.myapplication.R

class AdapterMenu(private val dataList: List<MenuCafe>) : RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.tvCode.text = item.kode
        holder.tvType.text = item.jenis
        holder.tvName.text = item.nama
        holder.tvPrice.text = item.harga
        holder.tvDesc.text = item.penjelasan
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCode: AppCompatTextView = itemView.findViewById(R.id.tv_code)
        val tvType: AppCompatTextView = itemView.findViewById(R.id.tv_type)
        val tvName: AppCompatTextView = itemView.findViewById(R.id.tv_name)
        val tvDesc: AppCompatTextView = itemView.findViewById(R.id.tv_desc)
        val tvPrice: AppCompatTextView = itemView.findViewById(R.id.tv_price)
    }
}
