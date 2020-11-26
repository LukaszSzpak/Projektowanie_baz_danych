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
                        Hello Librarian
                        </h1>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="change_data_button_lib" variant ="contained" color="primary" >Change personal data</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="borrow_book_lib" variant ="contained" color="primary" >Borrow a book</Button>  
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="add_new_title_lib" variant ="contained" color="primary" >Add new title</Button>    
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="add_new_book_lib" variant ="contained" color="primary" >Add new book</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="button_log_out_lib" variant ="contained" color="primary" >Log out</Button>
                    </Grid>
                </form>
            </div>
        </Grid>
    );
}