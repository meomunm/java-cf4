package org.example.view;

import org.example.controller.BaseController;
import org.example.model.BaseModel;

import java.io.IOException;

public abstract class BaseView {
    public BaseModel baseModel;

    /// MARK: Vẽ lại giao diện
    public abstract void onDraw() throws IOException;
}
