package com.proyecto.gestionproductos.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.gestionproductos.R;
import com.proyecto.gestionproductos.modelo.Producto;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    public interface OnToqueLargo {
        void alToqueLargo(Producto producto);
    }

    private final List<Producto> productos;
    private final OnToqueLargo listener;

    public ProductoAdapter(List<Producto> productos, OnToqueLargo listener) {
        this.productos = productos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.tvProducto.setText(producto.getNombre() + "  -  $" + producto.getPrecio());
        holder.itemView.setOnLongClickListener(v -> {
            listener.alToqueLargo(producto);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProducto;

        ViewHolder(View itemView) {
            super(itemView);
            tvProducto = itemView.findViewById(R.id.tvProducto);
        }
    }
}