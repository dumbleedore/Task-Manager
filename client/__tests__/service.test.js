import axios from 'axios';
const {fetchTaskManagerList} = require("../services/services");
jest.mock("axios");
describe("fetchManagerList", () => {
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
  })});