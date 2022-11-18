import axios from 'axios';
const {fetchTaskManagerList,updateTask,createTask} = require("../services/services");
jest.mock("axios");
it("returns the title of the first album", async () => {
    axios.get.mockResolvedValue({
    data: [
        {
            id: 0,
            nome: "",
            descricao: "",
            status: "aberto",
            data: "",
        }
      ],
    });
    const tasks = await fetchTaskManagerList();

    
    // ASSERTS
    expect(tasks[0].id).toEqual(0);
    expect(tasks.length).toEqual(1);
  })

  it("updates the task",async () =>{
    const task  = {
      id:1,
      nome:"teste",
      descricao:"teste",
      status:"aberto",
      data:"data",
    }
    axios.put.mockResolvedValue(
        {
          data:  {
            id: 1,
            nome: "teste atualizado",
            descricao: "teste atualizado",
            status: "aberto",
            data: "data",
        }
        }
      )
    const updatedTask = await updateTask(task.id,task);
    // ASSERTS
    expect(updatedTask.nome).toEqual("teste atualizado");
    expect(updatedTask.descricao).toEqual("teste atualizado");

  })
  it("creates a task",async () =>{
    const task  = {
      nome:"teste",
      descricao:"teste",
      status:"aberto",
      data:"data",
    }
    axios.post.mockResolvedValue(
        {
          data:  {
            id: 1,
            nome: "teste",
            descricao: "teste",
            status: "aberto",
            data: "data",
        }
        }
      )
    const taskCreated = await createTask(task);
    // ASSERTS
    expect(taskCreated.nome).toEqual("teste");
    expect(taskCreated.id).toEqual(1);

  })