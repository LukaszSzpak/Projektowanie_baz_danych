import React from 'react'
import {Grid, TextField, Button} from '@material-ui/core'

export default function ShowMenu() {
    return (
        <Grid
            container
            direction="row"
            justify="center"
            alignItems="center"
            >
            <div>
                <form>
                    <Grid item xs={12}>
                        <h1>
                        Hello Admin
                        </h1>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="change_data_button_adm" variant ="contained" color="primary" >Manage personel</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="borrow_book_adm" variant ="contained" color="primary" >Manage clients</Button>  
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="add_new_title_adm" variant ="contained" color="primary" >Add new title</Button>    
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="add_new_book_adm" variant ="contained" color="primary" >Add new book</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="button_log_out_adm" variant ="contained" color="primary" >Log out</Button>
                    </Grid>
                </form>
            </div>
        </Grid>
    );
}